import { useState } from "react";
import api from "../../utils/api";
export const TourSearch = ({ onResults, onClear }) => {
  const [title, setTitle] = useState("");
  const [date, setDate] = useState("");

  const searchTours = async () => {
    try {
      const res = await api.get("/tour/search", {
        params: {
          title: title.trim() || undefined,
          date: date || undefined,
        },
      });
      onResults(res.data);
    } catch (err) {
      onResults([]);
    }
  };

  const clearSearch = () => {
    setTitle("");
    setDate("");
    onClear();
  };

  return (
    <div className="p-4 max-w-3xl mx-auto">

      <div className="flex flex-col gap-2 md:flex-row md:items-end mb-4">
        <div className="flex flex-col w-full">
          <label className="font-medium">Title</label>
          <input
            type="text"
            value={title}
            onChange={(e) => setTitle(e.target.value)}
            className="input input-bordered"
            placeholder="Enter part of tour title"
          />
        </div>

        <div className="flex flex-col w-full">
          <label className="font-medium">Date</label>
          <input
            type="date"
            value={date}
            onChange={(e) => setDate(e.target.value)}
            className="input input-bordered"
          />
        </div>

        <button
          onClick={searchTours}
          className="btn btn-primary mt-2 md:mt-0 md:ml-4"
        >
          Search
        </button>

        <button
          onClick={clearSearch}
          className="btn btn-secondary mt-2 md:mt-0 md:ml-2"
        >
          Clear
        </button>
      </div>
    </div>
  );
};
