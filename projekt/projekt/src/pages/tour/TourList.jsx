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
    
      <div className="bg-red-500 btn justify-center mt-1">
      <NavLink to={`/tour/add`}>Add</NavLink>
</div>
      <ul>
        
      </ul>
      
    </>
  );
};
