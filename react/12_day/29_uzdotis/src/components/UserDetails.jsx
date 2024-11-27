import { useParams } from "react-router";
import { useState, useEffect } from "react";
import "./UserDetails.css"
export default function UserDetails() {
  const [data, setData] = useState(null);
  const [loding, setLoding] = useState(true);
  const [error, setError] = useState(null);
  const { id } = useParams();
  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch(
          `https://jsonplaceholder.typicode.com/users/${id}`
        );
        const data = await response.json();
    
        setData(data);
        setLoding(false);
      } catch (error) {
        setError(error.message);
        setLoding(false);
      }
      
    };
    fetchData();
  }, []);
  if (loding) {
    return <p>Loading...</p>;
  }
  if (error) {
    return <p>Error:{error}</p>;
  }

  return (
    <>
    <div className="conteiner">

    <div className="text-center">
    <h2>{data.username}</h2>
    <p>{data.name}</p>
    <p>{data.company.name}</p>
    <p>{data.website}</p>
    </div>
    </div>

    </>
  );
}
