import { NavLink } from "react-router";
import { Error } from "../../components/Error.jsx";
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
      <NavLink to={`/tour/add`}>Add</NavLink>

      <ul>
        {con}
      </ul>
    </>
  );
};
