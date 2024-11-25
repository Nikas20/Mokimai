export default function Card({
  logo,
  company,
  position,
  postedAt,
  contract,
  location,
}) {
  return (
    <div className="row border rounded p-2">
      <div className="col-3 col-md-2 col-xl-1px-1">
        <img src={logo} alt={company} />
      </div>
      <div className="col-8 px-5">
        <h2>{company}</h2>
        <p>{position}</p>
        <div className="d-flex">
          <p className="px-1">{postedAt}</p>
          <p className="px-1">{contract}</p>
          <p className="px-1">{location}</p>
        </div>
      </div>
    </div>
  );
}