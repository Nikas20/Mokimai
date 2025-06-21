import { NavLink } from "react-router";
import { useState } from "react";
import api from "../../utils/api.js";
import { Error } from "../../components/Error.jsx";
import { usePagination } from "../../context/PaginationContext.jsx";
import { useAuth } from "../../context/AuthContext";
export const TourCard = ({ tour }) => {
  const {
    id,
    title,
    description,
    price,
    photo_url,
    duration_minutes,
    max_participants,
    average_rating,
  } = tour;
 const { account } = useAuth();
  const [error, setError] = useState("");
  const { getPage, currentPage, pageSize } = usePagination();

  const deleteTour = async () => {
    try {
      await api.delete(`/tour/${id}`);
      getPage(pageSize, currentPage);
    } catch (err) {
      const errMsg =
        typeof err.response?.data === "string"
          ? err.response.data
          : err.response?.data?.message || "Unknown error";
      setError(errMsg);
    }
  };

  const checkRoleAdmin = () => {
    return (
      (account !== null &&
        account.scope !== null &&
        account?.scope.includes("ROLE_ADMIN"))
    );
  };

  const checkRoleUser = () => {
    return (
      (account !== null &&
        account.scope !== null &&
        account?.scope.includes("ROLE_USER"))
    );
  };

  return (
    <div className="card card-side shadow-sm bg-[#6A7AFF] text-[#FFFFFF] p-4">
      <div className="card-body w-full">
        <h2 className="card-title block break-words">{title}</h2>
        <textarea
          readOnly
          className="caret-transparent h-full min-h-[100px] w-full resize-none text-sm focus:outline-none"
        >
          {description}
        </textarea>

        {photo_url && (
          <img
            src={photo_url}
            alt={title}
            className="rounded-lg object-cover w-full max-h-60 my-2"
          />
        )}

        <p>Duration: {duration_minutes} minutes</p>
        <p>Max Participants: {max_participants}</p>
        <p>
          ⭐ Average Rating:{" "}
          {average_rating != null ? average_rating.toFixed(1) : "No ratings yet"}
        </p>
        <p>Price: ${price}</p>

        <div className="card-actions mt-4 flex gap-2">
          {checkRoleAdmin() && (
          <button
            onClick={deleteTour}
            className="btn btn-error bg-white text-black border-0 hover:bg-gray-200"
          >
            Delete
          </button>
          )}
{checkRoleAdmin() && (
          <NavLink
            to={`/tour/edit/${id}`}
            className="btn btn-primary bg-white text-black border-0 hover:bg-gray-200"
          >
            Edit
          </NavLink>
)}
{checkRoleUser() && (
          <NavLink
            to={`/tour/${id}`}
            className="btn btn-primary bg-white text-black border-0 hover:bg-gray-200"
          >
            View
          </NavLink>
          )}
        </div>

        {error && <Error error={error} isHidden={!error} />}
      </div>
    </div>
  );
};
