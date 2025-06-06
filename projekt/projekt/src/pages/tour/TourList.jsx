import { NavLink } from "react-router";
import { Error } from "../../components/Error.jsx";
import { TourCard } from "./TourCard.jsx";
import { usePagination } from "../../context/PaginationContext.jsx";

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

  return (
    <>
      <div className="bg-red-500 btn justify-center mt-1 p-2 text-center">
        <NavLink to={`/tour/add`}>Add</NavLink>
      </div>

      {error && <Error message={error} />}

      {Array.isArray(content) && content.length > 0 ? (
        content.map((tour) => 
        <TourCard 
          key={tour.id}
          tour={tour}
          getTourPage={getPage}
          currentPage={currentPage}
          pageSize={pageSize}
         
         />
        ) 
      ) : (
        <p>No tours available</p>
      )}


      {/* Pagination controls */}
      <div className="pagination-controls">
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

        {/* Example page size selector */}
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
    </>
  );
};