import { useForm } from "react-hook-form";
import { addTour } from "../../utils/helper/Tourservices";
import { useNavigate } from "react-router";
import { useState, useEffect } from "react";
import api  from "../../utils/api"; 

export const TourAdd = () => {
  const navigate = useNavigate();
  const [submitError, setSubmitError] = useState(null);
  const [isLoading, setIsLoading] = useState(false);
  const [categories, setCategories] = useState([]);

  const [dates, setDates] = useState([]);
  const [currentDate, setCurrentDate] = useState("");

  const {
    register,
    handleSubmit,
    reset,
    formState: { errors },
  } = useForm();

  useEffect(() => {
     api.get("/categories").then(res => setCategories(res.data));
  }, []);

  const formSubmitHandler = async (data) => {
    setIsLoading(true);
    setSubmitError(null);

    const payload = {
      title: data.title.trim(),
      description: data.description.trim(),
      photo_url: data.photo_url.trim(),
      duration_minutes: parseInt(data.duration_minutes),
      price: parseFloat(data.price),
      categoryIds: data.categoryIds,
      dates,
    };

    try {
      const response = await addTour(payload);
      console.log("Tour added:", response);

      reset({
        title: "",
        description: "",
        photo_url: "",
        duration_minutes: "",
        price: "",
        categoryIds: []
      });
      setDates([]);
      setCurrentDate("");
      navigate("/tour");
    } catch (error) {
      console.error("POST /tour error:", error.response?.data || error);
      setSubmitError(error.response?.data?.message || error.message);
    } finally {
      setIsLoading(false);
    }
  };

  const addDate = () => {
    if (currentDate && !dates.includes(currentDate)) {
      setDates([...dates, currentDate]);
      setCurrentDate("");
    }
  };

  const removeDate = (dateToRemove) => {
    setDates(dates.filter(d => d !== dateToRemove));
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

            <label htmlFor="title" className="fieldset-label">Title</label>
            <input id="title" {...register("title", {
              required: "Title is required", minLength: 3, maxLength: 150,
            })} className="input" disabled={isLoading} />

            <label htmlFor="description" className="fieldset-label">Description</label>
            <input id="description" {...register("description", {
              required: "Description is required", minLength: 3, maxLength: 150,
            })} className="input" disabled={isLoading} />

            <label htmlFor="photo_url" className="fieldset-label">Photo URL</label>
            <input id="photo_url" {...register("photo_url", { required: true })}
              className="input" disabled={isLoading} />

            <label htmlFor="duration_minutes" className="fieldset-label">Duration (minutes)</label>
            <input id="duration_minutes" type="number" {...register("duration_minutes", {
              required: true, min: 1,
            })} className="input" disabled={isLoading} />

            <label htmlFor="price" className="fieldset-label">Price</label>
            <input id="price" type="number" step="0.01" {...register("price", {
              required: true, min: 0,
            })} className="input" disabled={isLoading} />

           <label className="fieldset-label">Categories</label>
<div className="flex flex-col gap-1 max-h-40 overflow-auto border rounded p-2">
 {categories.map(c => (
  <label key={c.id} className="inline-flex items-center gap-2">
    <input
      type="checkbox"
      value={c.categoryName} 
      {...register("categoryIds")}
      disabled={isLoading}
    />
    {c.categoryName.replace(/^CATEGORY_/, "")} 
  </label>
  ))}
</div>

            <label htmlFor="date" className="fieldset-label">Add Date</label>
            <div className="flex gap-2 mb-2">
              <input
                type="date"
                id="date"
                value={currentDate}
                onChange={(e) => setCurrentDate(e.target.value)}
                className="input"
                disabled={isLoading}
              />
              <button type="button" onClick={addDate} className="btn">+</button>
            </div>

            {dates.length > 0 && (
              <ul className="list-disc ml-4">
                {dates.map((d, i) => (
                  <li key={i} className="flex justify-between items-center">
                    {new Date(d).toLocaleDateString()}
                    <button type="button" onClick={() => removeDate(d)} className="ml-2 text-red-500">
                      X
                    </button>
                  </li>
                ))}
              </ul>
            )}

            <button type="submit" disabled={isLoading}
              className="btn bg-black text-white mt-4">
              {isLoading ? "Submitting..." : "Add Tour"}
            </button>
          </fieldset>
        </form>
      </div>
    </main>
  );
};
