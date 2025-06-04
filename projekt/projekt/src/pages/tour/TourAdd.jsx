import { useForm } from "react-hook-form";
import { addTour } from "../../utils/helper/Tourservices";
import { useNavigate } from "react-router";
import { useState } from "react";

export const TourAdd = () => {
  const navigate = useNavigate();
  const [submitError, setSubmitError] = useState(null);
  const [isLoading, setIsLoading] = useState(false);

  const {
    register,
    handleSubmit,
    reset,
    formState: { errors },
  } = useForm();

  const formSubmitHandler = async (data) => {
    setIsLoading(true);
    setSubmitError(null);

    const trimmedData = {
      title: data.title.trim()
    };

    const payload = { ...trimmedData };

    try {
      let response1;
      response1 = await addTour(payload);
      console.log("Resetting form...");
      console.log(response1);
      
      reset({title: "",
        description: "",
        photo_url: "",
        duration_minutes: "",
        price: "",
      });
    } catch (error) {
      setSubmitError(error.response?.data?.message || error.message);
    } finally {
      setIsLoading(false);
    }
  };

  return (
    <main className="grid place-items-center h-screen">
      <div className="flex flex-col gap-2 items-center">
        <form onSubmit={handleSubmit(formSubmitHandler)} noValidate>
          {submitError && (
            <p className="bg-red-700 text-white p-2 rounded">{submitError}</p>
          )}
          <fieldset className="bg-[#97a0f1] w-xs border border-base-300 p-4 rounded-box">
            <legend className="fieldset-legend pt-8">Add Tour</legend>

            <label htmlFor="title" className="fieldset-label">
              Title
            </label>
            <input
              id="title"
              {...register("title", {
                required: "Title is required",
                minLength: { value: 3, message: "Minimum length is 3" },
                maxLength: { value: 150, message: "Maximum length is 150" },
                pattern: {
                  value: /^[A-Za-z0-9\s-]+$/,
                  message:
                    "Only letters, numbers, spaces, and hyphens allowed",
                },
              })}
              type="text"
              className="input focus:outline-none focus:border-base-300"
              placeholder="Enter title of tour"
              disabled={isLoading}
            />
            {errors.title && (
              <p className="text-red-600">{errors.title.message}</p>
            )}

            <label htmlFor="description" className="fieldset-label">
              Description
            </label>
            <input
              id="description"
              {...register("description", {
                required: "Description is required",
                minLength: { value: 3, message: "Minimum length is 3" },
                maxLength: { value: 150, message: "Maximum length is 150" },
              })}
              type="text"
              className="input focus:outline-none focus:border-base-300"
              placeholder="Enter description of tour"
              disabled={isLoading}
            />
            {errors.description && (
              <p className="text-red-600">{errors.description.message}</p>
            )}

            <label htmlFor="photo_url" className="fieldset-label">
              Photo URL
            </label>
            <input
              id="photo_url"
              {...register("photo_url", {
                required: "Photo URL is required",
                
              })}
              type="text"
              className="input focus:outline-none focus:border-base-300"
              placeholder="Enter photo URL of tour"
              disabled={isLoading}
            />
            {errors.photo_url && (
              <p className="text-red-600">{errors.photo_url.message}</p>
            )}

            <label htmlFor="duration_minutes" className="fieldset-label">
              Duration (minutes)
            </label>
            <input
              id="duration_minutes"
              {...register("duration_minutes", {
                required: "Duration is required",
                min: { value: 1, message: "Must be at least 1 minute" },
              })}
              type="number"
              className="input focus:outline-none focus:border-base-300"
              placeholder="Enter duration in minutes"
              disabled={isLoading}
            />
            {errors.duration_minutes && (
              <p className="text-red-600">{errors.duration_minutes.message}</p>
            )}

            <label htmlFor="price" className="fieldset-label">
              Price
            </label>
            <input
              id="price"
              {...register("price", {
                required: "Price is required",
                min: { value: 0, message: "Price cannot be negative" },
              })}
              type="number"
              step="0.01"
              className="input focus:outline-none focus:border-base-300"
              placeholder="Enter price of tour"
              disabled={isLoading}
            />
            {errors.price && (
              <p className="text-red-600">{errors.price.message}</p>
            )}

            <button
              type="submit"
              disabled={isLoading}
              className="btn bg-black border-neutral-950 text-white hover:bg-white hover:text-neutral-950 mt-4"
            >
              {isLoading ? "Submitting..." : "Add Tour"}
            </button>
          </fieldset>
        </form>
      </div>
    </main>
  );
}