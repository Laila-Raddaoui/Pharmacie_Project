import React, { useState, useEffect } from "react";
import axios from "axios";
import { Map, Marker, GoogleApiWrapper } from "google-maps-react";
import { useParams } from "react-router-dom";
import { Card } from "antd";

const customizeMap = {
  width: "50%",
  height: "600%",
};

const infoContainerStyle = {
  padding: "16px",
};

const GoogleMapComponent = ({ google }) => {
  const [coords, setCoords] = useState([]);
  const [initialCenter, setInitialCenter] = useState({
    lat: 31.6665735,
    lng: -7.9754785,
  });
  const [pharmInfo, setPharmInfo] = useState(null);

  const { id } = useParams();

  useEffect(() => {
    axios
      .get(`/api/pharmacies/${id}`)
      .then((response) => {
        const data = response.data;

        // Check if data has latitude and longitude properties
        if (data.lattitude && data.longtitude) {
          const coordinates = {
            lat: data.longtitude,
            lng: data.lattitude,
          };
          setCoords([coordinates]);
          setInitialCenter(coordinates);

        } else {
          // Handle the case when data does not have the expected properties
          console.error("Invalid data structure:", data);
        }

        setPharmInfo(data);
      })
      .catch((error) => {
        console.error("Error fetching data:", error);
      });
  }, [id]);

  const drawMarker = () => {
    return coords.map((coord, i) => {
      const { lat, lng } = coord;

      return (
        <Marker
          key={i}
          id={i}
          position={{
            lat: lat,
            lng: lng,
          }}
          onClick={() => console.log("Event Handler Called")}
        />
      );
    });
  };

  return (
    <div>
      <h1>Pharmacies Details</h1>
      <div style={{ display: "flex" }}>
        <div style={{ marginLeft: 10, marginRight: 10, flex: 1 }}>
          <Map
            google={google}
            style={customizeMap}
            zoom={10}
            initialCenter={initialCenter}
          >
            {drawMarker()}
          </Map>
        </div>
      </div>
    </div>
  );
};

export default GoogleApiWrapper({
  apiKey: "AIzaSyCsA6hQ1C8D6IIeB_r2WDEEgPelvpUWIf8&amp;region=MA",
})(GoogleMapComponent);