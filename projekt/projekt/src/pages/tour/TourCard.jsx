import { NavLink } from "react-router";
import { useAuth } from "../../context/AuthContext.jsx";
import api from "../../utils/api.js";
import { Error } from "../../components/Error.jsx";
import { useState } from "react";
import { usePagination } from "../../context/PaginationContext.jsx";

export const TourCard = (props) => {
    const {tour} = props;
    const {id, title, description, photo_url, duration_minutes, price, max_participants, average_rating} = tour;
    const [error, setError] = useState("");
    const { account } = useAuth();

    return(
        <div className="card card-side shadow-sm bg-[#6A7AFF] text-[#FFFFFF]">
            <div className="card-body">
            <h2 className="card-title block break-all">{title}</h2>
            <p>{description}</p>
            <p>{photo_url}</p>
            <p>{duration_minutes}</p>
            <p>{price}</p>
            <p>{max_participants}</p>
            <p>{average_rating}</p>
            </div>
        </div>
    )
}