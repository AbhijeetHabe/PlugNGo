import React, { useState } from "react";
import api from "../api/axiosConfig";
import "./AdminPage.css";
import "../Components/Header";

export const AdminPage = () => {
  const [searchQuery, setSearchQuery] = useState("");
  const [chargingStations, setChargingStations] = useState([
    { station_name: "", contact: "", address: "", status: "" }
    // Add more charging station data as needed
  ]);

  const [showForm, setShowForm] = useState(false);
  const [newStationData, setNewStationData] = useState({
    station_name: "",
    address: "",
    contact: "",
    photos: [],
  });

  const handleSearchQueryChange = (event) => {
    setSearchQuery(event.target.value);
  };

  const handleAddStation = () => {
    setShowForm(true); // Show the form when adding a new station
  };

  const handleLogoutStation = () => {
    setShowForm(true); // Show the form when adding a new station
  };

  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setNewStationData((prevData) => ({ ...prevData, [name]: value }));
  };

  const handleFileChange = (event) => {
    const files = event.target.files;
    setNewStationData((prevData) => ({ ...prevData, photos: files }));
  };

  const handleSubmit = () => {
    // Add new station data to the chargingStations array
    const newStation = {
      station_name: newStationData.station_name,
      address: newStationData.address,
      contact: newStationData.contact,
      status: "Active", // Assuming all new stations are active
    };

    api.post("/api/v1/addStation", newStation);

    setChargingStations([...chargingStations, newStation]);
    setShowForm(false); // Hide the form after submitting
    setNewStationData({ station_name: "", contact: "", address: "", photos: [] });
  };

  const handleDeleteStation = (stationId) => {
    // Delete the station with the specified ID from chargingStations
    const updatedStations = chargingStations.filter(
      (station) => station.id !== stationId
    );
    setChargingStations(updatedStations);
  };

  return (
    <div className="admin-page">
      <header>
        <h4>
          <div className="header-section">PLUGNGo</div>
        </h4>
        <button onClick={handleLogoutStation}>
          <div className="header-section">Logout</div>
        </button>
      </header>
      <main>
        <h1>My Charging Stations</h1>
        <section>
          <div className="search-bar">
            <input
              type="text"
              placeholder="Search for stations..."
              value={searchQuery}
              onChange={handleSearchQueryChange}
            />
            <button onClick={handleAddStation}>Add new station</button>
          </div>
          {showForm && (
            <form className="station-form">
              <label>Station Name</label>
              <input
                type="text"
                name="name"
                value={newStationData.station_name}
                onChange={handleInputChange}
              />
              <label> address</label>
              <input
                type="text"
                name="address"
                value={newStationData.address}
                onChange={handleInputChange}
              />
              <label>Contact</label>
              <input
                type="text"
                name="contact"
                value={newStationData.contact}
                onChange={handleInputChange}
              />
              <label>Photos</label>
              <input
                type="file"
                name="photos"
                multiple
                onChange={handleFileChange}
              />
              <button type="button" onClick={handleSubmit}>
                Submit
              </button>
            </form>
          )}
          <ul className="station-list">
            {chargingStations.map((station) => (
              <li key={station.id}>
                <strong>{station.station_name}</strong> - {station.address} (
                {station.status})
                <button onClick={() => handleDeleteStation(station.id)}>
                  Delete
                </button>
              </li>
            ))}
          </ul>
        </section>
      </main>
    </div>
  );
};

export default AdminPage;
