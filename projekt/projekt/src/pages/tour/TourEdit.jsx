import { useForm } from "react-hook-form";
import { useNavigate, useParams } from "react-router";
import { updateTour } from "../../utils/helper/Tourservices.js";
import api from "../../utils/api";
import { useState, useEffect } from "react";
import { Error } from "../../components/Error.jsx";

export const TourEdit = () => {
  const { id } = useParams();
  const navigate = useNavigate();
  const [error, setError] = useState(null);
  const {
    register,
    handleSubmit,
    reset,
    setValue,
    formState: { errors },
  } = useForm();
  const [isLoading, setIsLoading] = useState(false);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await api.get(`/tour/${id}`);
        const data = response.data;

        const {
          title,
          description,
          photo_url,
          duration_minutes,
          price,
        } = data;

        setValue("title", title);
        setValue("description", description);
        setValue("photo_url", photo_url);
        setValue("duration_minutes", duration_minutes);
        setValue("price", price);
      } catch (error) {
        setError(error.response?.data?.message || error.message);
      }
    };

    fetchData();
  }, [id, setValue]);

  const formSubmitHandler = async (data) => {
    setIsLoading(true);
    setError(null);

    const payload = {
      ...data,
      title: data.title.trim(),
      description: data.description.trim(),
      photo_url: data.photo_url.trim(),
      duration_minutes: parseInt(data.duration_minutes),
      price: parseFloat(data.price),
    };

    try {
      await updateTour(id, payload);

      reset({
        title: "",
        description: "",
        photo_url: "",
        duration_minutes: "",
        price: "",
      });

      navigate("/tour");
    } catch (error) {
      setError(error.response?.data?.message || error.message);
    } finally {
      setIsLoading(false);
    }
  };

  return (
    <main className="grid place-items-center h-screen">
      <div className="flex flex-col gap-2 items-center">
        <form onSubmit={handleSubmit(formSubmitHandler)}>
          <fieldset className="bg-[#97a0f1] w-xs border border-base-300 p-4 rounded-box">
            <legend className="fieldset-legend pt-8">Edit Tour</legend>

            <label className="fieldset-label">Title</label>
            <input
              {...register("title", {
                required: "Title is required",
                minLength: 3,
                maxLength: 150,
              })}
              type="text"
              className="input focus:outline-none focus:border-base-300"
              placeholder="Enter tour title"
            />
            {errors.title && (
              <p className="text-red-600">{errors.title.message}</p>
            )}

            <label className="fieldset-label">Description</label>
            <textarea
              {...register("description", {
                required: "Description is required",
                maxLength: 255,
              })}
              rows="6"
              className="block w-full text-sm resize-none text-gray-900 bg-gray-50 focus:outline-none"
              placeholder="Enter description"
            />
            {errors.description && (
              <p className="text-red-600">{errors.description.message}</p>
            )}

            <label className="fieldset-label">Photo URL</label>
            <input
              {...register("photo_url", {
                required: "Photo URL is required",
              })}
              type="text"
              className="input focus:outline-none focus:border-base-300"
              placeholder="Enter photo URL"
            />
            {errors.photo_url && (
              <p className="text-red-600">{errors.photo_url.message}</p>
            )}

            <label className="fieldset-label">Duration (minutes)</label>
            <input
              {...register("duration_minutes", {
                required: "Duration is required",
                min: 1,
              })}
              type="number"
              className="input focus:outline-none focus:border-base-300"
              placeholder="Enter duration"
            />
            {errors.duration_minutes && (
              <p className="text-red-600">{errors.duration_minutes.message}</p>
            )}

            <label className="fieldset-label">Price</label>
            <input
              {...register("price", {
                required: "Price is required",
                min: 0,
              })}
              type="number"
              step="0.01"
              className="input focus:outline-none focus:border-base-300"
              placeholder="Enter price"
            />
            {errors.price && (
              <p className="text-red-600">{errors.price.message}</p>
            )}

            <button
              type="submit"
              className="btn bg-black border-neutral-950 text-white hover:bg-white hover:text-neutral-950 mt-4"
              disabled={isLoading}
            >
              {isLoading ? "Updating..." : "Update Tour"}
            </button>
          </fieldset>

          <Error error={error} isHidden={!error} />
        </form>
      </div>
    </main>
  );
};
