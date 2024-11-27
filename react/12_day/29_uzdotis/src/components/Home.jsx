import { useState, useEffect } from "react";

export default function Home() {
  const [data, setData] = useState(null);
  const [loding, setLoding] = useState(true);
  const [error, setError] = useState(null);
  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch(
          "https://jsonplaceholder.typicode.com/users"
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
    <><div>
      <div className="row">
        {data.map((card) => {
          return (
            <div key={card.id} className="= col-4 text-center">
              <svg
                className="bd-placeholder-img rounded-circle"
                width="140"
                height="140"
                xmlns="http://www.w3.org/2000/svg"
                role="img"
                aria-label="Placeholder"
                preserveAspectRatio="xMidYMid slice"
                focusable="false"
              >
                <title>Placeholder</title>
                <rect
                  width="100%"
                  height="100%"
                  fill="var(--bs-secondary-color)"
                ></rect>
              </svg>
              <h2 className="fw-normal">{card.username}</h2>
              <p>
                <a className="btn btn-secondary" href={"/users/" + card.id}>
                  View details »
                </a>
              </p>
            </div>
            
          );
        })}
      </div>
      </div>
    </>
  );
}
