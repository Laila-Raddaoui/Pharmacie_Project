import React, {useEffect, useMemo, useReducer, useState} from 'react';
import {Button, Col, Form, Input, Modal, Row, Space, Table} from "antd";
import axios from "axios";

function VilleComponent() {
    const [open, setOpen] = useState(false);
    const [confirmLoading] = useState(false);
    const [upTB, forceUpdate] = useReducer((x) => x + 1, 0);
    const [villes, setVilles] = useState([]);
    const [form] = Form.useForm();

    const columns = [
        {
            title: 'Nom de ville',
            dataIndex: 'nom',
            key: 'nom',
            align: 'center',
        },
        {
            title: 'Actions',
            dataIndex: 'id',
            key: 'actions',
            align: 'center',
            render: (_, record, index) => (
                <Space size="middle">
                    <Button shape="round" onClick={e => {
                        axios.delete('/api/villes/delete', {data: {id: record.id}})
                            .then(() => {
                                forceUpdate()
                            })
                            .catch(function (error) {
                                console.log(error);
                            });
                    }} size="small" danger>Delete</Button>
                </Space>
            ),
        }
    ];

    useEffect(() => {
        axios.get('/api/villes/')
            .then((data) =>
                setVilles(data.data))
            .catch(error => console.log(error));
    }, [upTB])

    const rows = useMemo(() => villes.map((ville) => (
        {id: ville.id, nom: ville.nom}
    )), [villes]);

    const onReset = () => {
        form.resetFields();
    };

    const onFinish = (values) => {
        axios.post('/api/villes/save', values)
            .then((data) => {
                console.log(data.data)
                forceUpdate()
                onReset()
                setOpen(false)
            })
            .catch(function (error) {
                console.log(error);
            });
    };

    const onFinishFailed = (errorInfo) => {
        console.log("Failed:", errorInfo);
    };

    const showModal = () => {
        setOpen(true);
    };

    const handleCancel = () => {
        setOpen(false);
        form.resetFields();
    };

    return (
        <>
            <Button type="primary"
                    style={{marginBottom: "1rem", border: "none", textTransform: "uppercase", fontWeight: "500"}}
                    onClick={showModal} ghost>
                Ajouter Nouveaux
            </Button>
            <Modal
                title="Ajouter Nouveaux Ville"
                open={open}
                confirmLoading={confirmLoading}
                onCancel={handleCancel}
            >
                <div>
                    <Form layout="vertical" className="main-form" name="basic" form={form}
                          initialValues={{
                              remember: true
                          }}
                          onFinish={onFinish}
                          onFinishFailed={onFinishFailed}>
                        <Row>
                            <Col span={24}>
                                <Form.Item label="Nom de Ville : " name="nom" rules={[
                                    {
                                        required: true,
                                    },
                                ]}>
                                    <Input placeholder="Nom de ville"/>
                                </Form.Item>
                            </Col>

                            <Col span={24}>
                                <Form.Item>
                                    <Button type="primary" htmlType="submit">Ajouter</Button>
                                </Form.Item>
                            </Col>
                        </Row>
                    </Form>
                </div>
            </Modal>
            <Table columns={columns} dataSource={rows} pagination={{pageSize: 6, position: 'bottomCenter'}}/>
        </>
    );
}

export default VilleComponent;