import { useState } from "react";
import Card from "./components/Card";
//import Card from "./components/Title";
import "./App.css";

export default function App() {
  return (
    <div class="row">
      <div class="col-sm-6"><Card/></div>
      <div class="col-sm-6">  <Card/></div>
  </div>
  );
}
//card-title="Task is not done"
     // button="bg-danger"