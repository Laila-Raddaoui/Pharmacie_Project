import React, {useMemo, useState} from 'react';
import {Container} from "react-bootstrap";
import {Col, Row, Table} from "antd";
import axios from "axios";
import Search from "antd/es/input/Search";

function ZoneByVilleComponent() {
    const [zones, setZones] = useState([]);

    const columns = [
        {
            title: 'Nom de Zone',
            dataIndex: 'nom',
            key: 'nom',
            align: 'center',
        },
    ];

    let rows = useMemo(() => zones.map((zone) => (
        {nom: zone.nom}
    )), [zones]);


    const onSearch = (value) => {
        axios.get(`/api/villes/${value}/zones`)
            .then((data) =>
                setZones(data.data))
            .catch(error => {
                console.log(error);
                setZones(nom => (['']));
            });
    }

    return (
        <>
            <Container>
                <Row>
                    <Col md={24}>
                        <Search
                            placeholder="Recherche"
                            allowClear
                            enterButton="Search"
                            size="large"
                            onSearch={onSearch}
                        />
                    </Col>
                </Row>
                <Table  style={{marginTop: "1.5rem"}} columns={columns} dataSource={rows}
                       pagination={{pageSize: 6, position: 'bottomCenter'}}/>
            </Container>
        </>
    );
}

export default ZoneByVilleComponent;