import { NavLink } from "react-router";
import { Error } from "../../components/Error.jsx";
import { TourCard } from "./TourCard.jsx";
import { usePagination } from "../../context/PaginationContext.jsx";
import { TourSearch } from "./TourSearch.jsx";
import { useState } from "react";
import { useAuth } from "../../context/AuthContext";
export const TourList = () => {
  const {
    getPage,
    onPageSizeChange,
    onPaginate,
    error,
    content,
    currentPage,
    totalPages,
    pageSize,
  } = usePagination();
  const { account } = useAuth();
  const [searchResults, setSearchResults] = useState([]);
  const [isSearching, setIsSearching] = useState(false);

const checkRoleAdmin = () => {
    return (
      (account !== null &&
        account.scope !== null &&
        account?.scope.includes("ROLE_ADMIN"))
    );
  };

  return (
    <div className="p-4">
      <TourSearch
        onResults={(results) => {
          setSearchResults(results);
          setIsSearching(results.length > 0);
        }}
        onClear={() => {
          setSearchResults([]);
          setIsSearching(false);
        }}
      />

{checkRoleAdmin() && (
      <div className="bg-red-500 btn justify-center mt-4 p-2 text-center">
        <NavLink to={`/tour/add`}>Add</NavLink>
      </div>
)}

      {error && <Error message={error} />}
<ul className="flex flex-col grid grid-cols-3 gap-4 ">
      {isSearching ? (
        <div className="grid gap-4 mt-4">
          {searchResults.map((tour) => (
            <TourCard key={tour.id} tour={tour} />
          ))}
        </div>
      ) : Array.isArray(content) && content.length > 0 ? (
        content.map((tour) => (
          <TourCard
            key={tour.id}
            tour={tour}
            getTourPage={getPage}
            currentPage={currentPage}
            pageSize={pageSize}
          />
        ))
      ) : (
        <p>No tours available</p>
      )}
</ul>
      {!isSearching && (
        <div className="pagination-controls mt-4">
          <button
            disabled={currentPage <= 1}
            onClick={() => onPaginate(currentPage - 1)}
          >
            Previous
          </button>
          <span>
            Page {currentPage} of {totalPages}
          </span>
          <button
            disabled={currentPage >= totalPages}
            onClick={() => onPaginate(currentPage + 1)}
          >
            Next
          </button>
          <select
            value={pageSize}
            onChange={(e) => onPageSizeChange(Number(e.target.value))}
          >
            {[5, 10, 20].map((size) => (
              <option key={size} value={size}>
                {size} per page
              </option>
            ))}
          </select>
        </div>
      )}
    </div>
  );
};
