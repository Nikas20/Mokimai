import { useState, useEffect } from "react";
import { Link } from "react-router";
import Status from "./Status"
export default function Library() {
    const [books, setBooks] = useState();

  const [data, setData] = useState(null);
  const [loding, setLoding] = useState(true);
  const [error, setError] = useState(null);
  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch("http://localhost:8080/books");
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
      <div className="row">
        {data.map((card) => {
          return (
            <div key={card.id} className="= col-2 px-4 ">
                <img src={card.cover} alt=""  className="bd-placeholder-img "
                width="140"
                height="200"/>
              
              <h2 className="">{card.title}</h2>
              <p className="text-secondary">{card.author}</p>
              <p className="">{card.category}</p>
              <p className="text-success"> {card.price}</p>
              <p><Link to={`/books/${card.id}`} className=" bg-info text-light">Edit</Link></p>
              <Status/>
            </div>
          );
        })}
      </div>

  );
}
