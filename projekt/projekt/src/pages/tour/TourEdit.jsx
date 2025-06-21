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
  const [dates, setDates] = useState([]);
  const [currentDate, setCurrentDate] = useState("");
  const [isLoading, setIsLoading] = useState(false);
  const [categories, setCategories] = useState([]);
  const [selectedCategories, setSelectedCategories] = useState([]);

  const {
    register,
    handleSubmit,
    reset,
    setValue,
    formState: { errors },
  } = useForm();

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await api.get(`/tour/${id}`);
        const { title, description, photo_url, duration_minutes, price, categories: fetchedCategories } = response.data;

        setValue("title", title);
        setValue("description", description);
        setValue("photo_url", photo_url);
        setValue("duration_minutes", duration_minutes);
        setValue("price", price);

        // ✅ Извлекаем category IDs из массива объектов
        setSelectedCategories((fetchedCategories || []).map(cat => cat.id));
      } catch (err) {
        setError(err.response?.data?.message || err.message);
      }

      try {
        const dateRes = await api.get(`/tour/${id}/dates`);
        setDates(dateRes.data.map(d => d.date));
      } catch {}
    };

    fetchData();
  }, [id, setValue]);

  useEffect(() => {
    api.get("/categories")
      .then(res => setCategories(res.data))
      .catch(() => {});
  }, []);

  const addDate = () => {
    if (currentDate && !dates.includes(currentDate)) {
      setDates([...dates, currentDate]);
      setCurrentDate("");
    }
  };

  const removeDate = (dateToRemove) => {
    setDates(dates.filter(d => d !== dateToRemove));
  };

  const toggleCategory = (categoryId) => {
    setSelectedCategories(prev =>
      prev.includes(categoryId)
        ? prev.filter(c => c !== categoryId)
        : [...prev, categoryId]
    );
  };

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
      categoryIds: selectedCategories,
      dates,
    };

    try {
      await updateTour(id, payload);
      reset();
      navigate("/tour");
    } catch (err) {
      setError(err.response?.data?.message || err.message);
    } finally {
      setIsLoading(false);
    }
  };

  return (
    <main className="grid place-items-center h-screen">
      <div className="flex flex-col gap-2 items-center">
        <form onSubmit={handleSubmit(formSubmitHandler)} noValidate>
          <fieldset className="bg-[#97a0f1] w-xs border border-base-300 p-4 rounded-box">
            <legend className="fieldset-legend pt-8">Edit Tour</legend>

            <label className="fieldset-label">Title</label>
            <input
              {...register("title", { required: "Title is required", minLength: 3, maxLength: 150 })}
              type="text" className="input" placeholder="Enter tour title" disabled={isLoading}
            />
            {errors.title && <p className="text-red-600">{errors.title.message}</p>}

            <label className="fieldset-label">Description</label>
            <textarea
              {...register("description", { required: "Description is required", maxLength: 255 })}
              rows="6" className="input resize-none" placeholder="Enter description" disabled={isLoading}
            />
            {errors.description && <p className="text-red-600">{errors.description.message}</p>}

            <label className="fieldset-label">Photo URL</label>
            <input
              {...register("photo_url", { required: "Photo URL is required" })}
              type="text" className="input" placeholder="Enter photo URL" disabled={isLoading}
            />
            {errors.photo_url && <p className="text-red-600">{errors.photo_url.message}</p>}

            <label className="fieldset-label">Duration (minutes)</label>
            <input
              {...register("duration_minutes", { required: true, min: 1 })}
              type="number" className="input" placeholder="Enter duration" disabled={isLoading}
            />
            {errors.duration_minutes && <p className="text-red-600">{errors.duration_minutes.message}</p>}

            <label className="fieldset-label">Price</label>
            <input
              {...register("price", { required: true, min: 0 })}
              type="number" step="0.01" className="input" placeholder="Enter price" disabled={isLoading}
            />
            {errors.price && <p className="text-red-600">{errors.price.message}</p>}

            <label className="fieldset-label">Categories</label>
            <div className="flex flex-col gap-1 max-h-40 overflow-auto border rounded p-2">
              {categories.map(c => (
                <label key={c.id} className="inline-flex items-center gap-2">
                  <input
                    type="checkbox"
                    value={c.id}
                    checked={selectedCategories.includes(c.id)}
                    onChange={() => toggleCategory(c.id)}
                    disabled={isLoading}
                  />
                  {c.categoryName.replace(/^CATEGORY_/, "")}
                </label>
              ))}
            </div>

            <label className="fieldset-label">Add Date</label>
            <div className="flex gap-2 mb-2">
              <input
                type="date"
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
                    <button type="button" onClick={() => removeDate(d)} className="ml-2 text-red-500">X</button>
                  </li>
                ))}
              </ul>
            )}

            <button type="submit" className="btn bg-black text-white mt-4" disabled={isLoading}>
              {isLoading ? "Updating..." : "Update Tour"}
            </button>
          </fieldset>

          <Error error={error} isHidden={!error} />
        </form>
      </div>
    </main>
  );
};
