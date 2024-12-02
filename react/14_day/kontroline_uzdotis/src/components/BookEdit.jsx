import { useEffect, useState } from "react";
import { useForm } from "react-hook-form";
import { useParams, useNavigate } from "react-router";

export default function BookEdit() {
    const navigate = useNavigate();
  const { id } = useParams();
  const [data, setData] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const { register, handleSubmit, formState: { errors } } = useForm();

  useEffect(() => {
    const fetchData = async () => {
      try {
        
        const response = await fetch(`http://localhost:3001/books/${id}`);
        const data = await response.json();

        setData(data);
        setLoading(false);
      } catch (error) {
        setError(error.message);
        setLoading(false);
      }
    };
    fetchData();
  }, []);
  const onSubmit = async (data) => {
    try {
      const response = await fetch(`http://localhost:3001/books/${id}`, {
        method: "PUT",
        body: JSON.stringify(data),
        headers: {
          "Countent-Type": "application/json",
        },
      });
      if (!response.ok) {
        throw new Error(`Respose ststus: ${response.status}`);
      }
      navigate("/");
    } catch (error) {
      console.error(error);
    }
  };
  if (loading) {
    return <p>Loding ...</p>;
  }
  if (error) {
    return <p>Error: {error}</p>;
  }

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
          defaultValue={data.title}
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
          defaultValue={data.author}
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
          defaultValue={data.category}
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
          defaultValue={data.price}
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
          defaultValue={data.cover}
       />
        
        {errors.cover?.type === "required" && <p>Flied cannot be empty</p>}
      </div>
      <button type="submit" className="btn btn-primary">
        Submit
      </button>
    </form>
  );
}