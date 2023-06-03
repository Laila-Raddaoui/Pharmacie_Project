import PharmacieComponent from './components/PharmacieComponent';
import GardeComponent from './components/GardeComponent';
import ZoneComponent from './components/ZoneComponent';
import VilleComponent from './components/VilleComponent';
import ZoneByVilleComponent from "./components/ZoneByVilleComponent";
import {Container, Nav, Navbar} from "react-bootstrap";
import {Col, Row} from "antd";
import 'bootstrap/dist/css/bootstrap.min.css';
import logo from './img/pharmacie.png';
import './App.css';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import GoogleMapComponent from "./components/Mapdetail"
import Mapdetail from './components/Mapdetail';

function App() {
    return (
        <>
            <Navbar bg="dark" variant="dark">
                <Container>
                    <Navbar.Brand href="#home">
                        <img
                            alt=""
                            src={logo}
                            width="30"
                            height="30"
                            className="d-inline-block align-top"
                        />{' '}
                        Pharmacies
                    </Navbar.Brand>
                    <Nav className="me-auto">
                        <Nav.Link href="/">Pharamcies</Nav.Link>
                        <Nav.Link href="/Gardes">Garde</Nav.Link>
                        <Nav.Link href="/zoneByVille">Zones by Ville</Nav.Link>
                        <Nav.Link href="/zones">Zones</Nav.Link>
                        <Nav.Link href="/villes">Villes</Nav.Link>
                        <Nav.Link href="/mappharm/:id" element={<GoogleMapComponent/>}></Nav.Link>
                        

                    </Nav>
                </Container>
            </Navbar>

            <Container>
                <Row className="content">
                    <Col md={24}>
                        <BrowserRouter>
                            <Routes>
                                <Route path="/" element={<PharmacieComponent/>}/>
                                <Route path="gardes" element={<GardeComponent/>}/>
                                <Route path="zoneByVille" element={<ZoneByVilleComponent/>}/>
                                <Route path="zones" element={<ZoneComponent/>}/>
                                <Route path="villes" element={<VilleComponent/>}/>
                                <Route path="/mappharm/:id" element={<GoogleMapComponent/>}/>
                            </Routes>
                        </BrowserRouter>
                    </Col>
                </Row>
            </Container>
        </>
    );
}

export default App;
