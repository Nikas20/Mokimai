import { useForm } from "react-hook-form";
import { useNavigate } from "react-router";
export default function Register() {
  const navigate = useNavigate();
  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm();
  const onSubmit = async (data) => {
    try {
      const response = await fetch("http://localhost:3001/books", {
        method: "POST",
        body: JSON.stringify(data),
        headers: {
          "Content-Type": "application/json",
        },
      });

      if (!response.ok) {
        throw new Error(`Response status: ${response.status}`);
      }
      navigate("/")
    } catch (error) {
      console.error(error);
    }
  };
  return (
    <form onSubmit={handleSubmit(onSubmit)} className="col-4 mx-auto">
      <div className="mb-3">
        <label htmlFor="title" className="form-label">
          Title
        </label>
        <input
          type="text"
          id="title"
          className="form-control"
          {...register("title", {
            required: true,
            minLength: 3,
            maxLength: 100,
          })}
        />
        {errors.title?.type === "required" && <p>Flied cannot be empty</p>}
        {errors.title?.type === "minLength" && (
          <p>Flied value cannot lover than 3</p>
        )}
        {errors.title?.type === "maxLength" && (
          <p>Flied value cannot higest than 100</p>
        )}
      </div>
      <div>
        <label htmlFor="author" className="form-label">
          Author
        </label>
        <input
          type="text"
          id="author"
          className="form-control"
          {...register("author", { required: true, pattern: /^[A-Z][a-z ]+$/ })}
        />
        {errors.author?.type === "required" && <p>Flied cannot be empty</p>}
        {errors.author?.type === "pattern" && (
          <p>In flied can be only a leters and spases,must begin a big leter</p>
        )}
      </div>
      <div>
        <label htmlFor="category" className="form-label">
          Category
        </label>
        <input
          type="text"
          id="category"
          className="form-control"
          {...register("category", { required: true })}
        />
        {errors.category?.type === "required" && <p>Flied cannot be empty</p>}
      </div>
      <div>
        <label htmlFor="price" className="form-label">
          Price
        </label>
        <input
          type="text"
          id="price"
          className="form-control"
          {...register("price", { required: true, min: 1 })}
        />
        {errors.price?.type === "required" && <p>Flied cannot be empty</p>}
        {errors.price?.type === "min" && (
          <p>Flied value must be biger than 0</p>
        )}
      </div>
      <div>
        <label htmlFor="cover" className="form-label">
          Cover
        </label>
        <input
          type="text"
          id="cover"
          className="form-control"
          {...register("cover", { required: true, regex: /^(https?:\/\/)?([\da-z\.-]+)\.([a-z\.]{2,6})([\/\w \.-]*)*\/?$/ })}
        />
        {errors.cover?.type === "required" && <p>Flied cannot be empty</p>}
      </div>
      <button type="submit" className="btn btn-primary">
        Submit
      </button>
    </form>
  );
}
