import { useEffect, useState } from "react";
import { useForm } from "react-hook-form";
import { useParams, useNavigate } from "react-router";

export default function EditTask() {
    const navigate = useNavigate();
  const { id } = useParams();
  const [data, setData] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const { register, handleSubmit, formState: { errors } } = useForm();

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch(`http://localhost:3001/tasks/${id}`);
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
      const response = await fetch(`http://localhost:3001/tasks/${id}`, {
        method: "PUT",
        body: JSON.stringify(data),
        headers: {
          "Countent-Type": "application/json",
        },
      });
      if (!response.ok) {
        throw new Error(`Respose ststus: ${response.status}`);
      }
      navigate("/tasks");
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
        <label htmlFor="name" className="form-label">
          Name
        </label>
        <input
          type="text"
          id="name"
          className="form-control"
          {...register("name", { required: true, minLength:2, maxLength:80, pattern: /^[A-Z][a-z ]+$/ })}
          />
          {errors.name?.type === "required" && <p>Name field cannot be empty</p>}
          {errors.name?.type === "pattern" &&  <p>Name must start with an uppercase letter</p>}
          {errors.name?.type === "minLength" && <p>Minimal lenght 2</p>}
          {errors.name?.type === "maxLength" && <p>Maximal lenght 80</p>}
      </div>

      <div className="mb-3">
        <label htmlFor="type" className="form-label">
        Due date
        </label>
        <input
          type="date"
          id="date"
          className="form-control"
          {...register("date", { required: true, valueAsDate:true})}
        />
      </div>
      <button type="submit" className="btn btn-primary">
        Submit
      </button>
    </form>
  );
}
