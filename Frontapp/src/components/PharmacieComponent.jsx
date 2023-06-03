import React, {useEffect, useMemo, useReducer, useState} from 'react';
import {Button, Col, Form, Input, Modal, Row, Select, Space, Table} from "antd";
import axios from "axios";
import { Link, useParams } from "react-router-dom";
import MapIcon from "./Mapdetail"

function PharmacieComponent() {
    const [open, setOpen] = useState(false);
    const [confirmLoading] = useState(false);
    const [upTB, forceUpdate] = useReducer((x) => x + 1, 0);
    const [pharmacies, setPharmacies] = useState([]);
    const [zones, setZones] = useState([]);
    const [form] = Form.useForm();

    const columns = [
        {
            title: 'Nom de pharmacies',
            dataIndex: 'nom',
            key: 'nom',
            align: 'center',
        },
        {
            title: 'Adresse',
            dataIndex: 'adresse',
            key: 'adresse',
            align: 'center',
        },
        {
            title: 'Téléphone',
            dataIndex: 'telephone',
            key: 'telephone',
            align: 'center',
        },
        {
            title: 'Latitude',
            dataIndex: 'latitude',
            key: 'latitude',
            align: 'center',
        }, {
            title: 'Longitude',
            dataIndex: 'longitude',
            key: 'longitude',
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
                        axios.delete('/api/pharmacies/delete', {data: {id: record.id}})
                            .then(() => {
                                forceUpdate()
                            })
                            .catch(function (error) {
                                console.log(error);
                            });
                    }} size="small" danger>Delete</Button>
                    <Link
                  className="btn btn-warning ml-2"
                  to={`/mappharm/${record.id}`}
                >
                  Map
                </Link>
                </Space>
            ),
        }
    ];

    useEffect(() => {
        axios.get('/api/pharmacies/')
            .then((data) =>
                setPharmacies(data.data))
            .catch(error => console.log(error));
    }, [upTB])

    const rows = useMemo(() => pharmacies.map((pharmacie) => (
        {
            id: pharmacie.id,
            nom: pharmacie.nom,
            adresse: pharmacie.adresse,
            telephone: pharmacie.telephone,
            latitude: pharmacie.latitude,
            longitude: pharmacie.longitude
        }
    )), [pharmacies]);

    useEffect(() => {
        axios.get('/api/zones/')
            .then((data) =>
                setZones(data.data))
            .catch(error => console.log(error));
    }, []);

    const options = useMemo(() => zones.map((zone) => (
        {
            value: zone.id,
            label: zone.nom,
        }
    )), [zones]);

    const onReset = () => {
        form.resetFields();
    };

    const onFinish = (values) => {
        axios.post('/api/pharmacies/save', {
            nom: values.nom,
            adresse: values.adresse,
            telephone: values.telephone,
            latitude: values.latitude,
            longitude: values.longitude,
            zone: {id: values.zone}
        })
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
                title="Ajouter Nouveaux Pharmacie"
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
                                <Form.Item style={{paddingBottom: "1.5rem"}} label="Nom de pharamcie" name="nom"
                                           rules={[{required: true,},]}>
                                    <Input placeholder="Nom de pharamcie"/>
                                </Form.Item>
                            </Col>

                            <Col span={24}>
                                <Form.Item style={{paddingBottom: "1.5rem"}} label="Adresse : " name="adresse"
                                           rules={[{required: true,},]}>
                                    <Input placeholder="Adresse"/>
                                </Form.Item>
                            </Col>

                            <Col span={24}>
                                <Form.Item style={{paddingBottom: "1.5rem"}} label="Téléphone : " name="telephone"
                                           rules={[{required: true,},]}>
                                    <Input placeholder="Téléphone"/>
                                </Form.Item>
                            </Col>

                            <Col span={24}>
                                <Form.Item style={{paddingBottom: "1.5rem"}} label="Latitude : " name="latitude"
                                           rules={[{required: true,},]}>
                                    <Input placeholder="Latitude"/>
                                </Form.Item>
                            </Col>

                            <Col span={24}>
                                <Form.Item style={{paddingBottom: "1.5rem"}} label="Longitude : " name="longitude"
                                           rules={[{required: true,},]}>
                                    <Input placeholder="Longitude"/>
                                </Form.Item>
                            </Col>

                            <Col span={24}>
                                <Form.Item style={{paddingBottom: "1.5rem"}} label="Zone : " name="zone"
                                           rules={[{required: true,},]}>
                                    <Select style={{width: "100%",}}
                                            options={options}
                                    />
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

export default PharmacieComponent;