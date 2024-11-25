import { useState } from "react";
import Header from "./components/Header";
import Card from "./components/Card";
import data from "./data/data.json";
export default function App() {
  return (
    <div>
      <Header />
      {data.map((value) => (
        <Card
          logo={value.logo}
          company={value.company}
          position={value.position}
          postedAt={value.postedAt}
          contract={value.contract}
          location={value.location}
        />
      ))}
    </div>
  );
}
