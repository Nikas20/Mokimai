import { useEffect, useState } from "react";
import api from "../../utils/api";
import { useAuth } from "../../context/AuthContext";

export const MyBookings = () => {
  const [bookings, setBookings] = useState([]);
  const [error, setError] = useState("");
  const [allDates, setAllDates] = useState([]);
  const [editingId, setEditingId] = useState(null);
  const [newDateId, setNewDateId] = useState("");
  const { account } = useAuth();
  const userId = account?.account_id;

  const fetchBookings = async () => {
    try {
      const res = await api.get(`/bookings/user/${userId}`);
      setBookings(res.data);
    } catch {
      setError("Failed to load bookings");
    }
  };

  const fetchAllDates = async () => {
    try {
      const res = await api.get(`/tour/dates`);
      setAllDates(res.data);
    } catch {
      setAllDates([]);
    }
  };

  const cancel = async (tourDateId) => {
    try {
      await api.delete(`/bookings`, { params: { userId, tourDateId } });
      fetchBookings();
    } catch {
      setError("Failed to cancel booking");
    }
  };

  const updateDate = async (bookingId) => {
    try {
      await api.put(`/bookings/${bookingId}/change-date`, { newDateId });
      setEditingId(null);
      fetchBookings();
    } catch {
      setError("Failed to change the date");
    }
  };

  useEffect(() => {
    fetchBookings();
    fetchAllDates();
  }, []);

  return (
    <div className="p-4">
      <h2 className="text-xl font-bold mb-4">My Tours</h2>

      {error && <p className="text-red-500">{error}</p>}

      {bookings.length === 0 ? (
        <p>No bookings</p>
      ) : (
        <ul className="space-y-2">
          {bookings.map((b) => (
            <li key={b.id} className="bg-gray-100 p-4 rounded">
              <p><strong>Tour:</strong> {b.tourDate?.tour?.title}</p>
              <p><strong>Date:</strong> {new Date(b.tourDate?.date).toLocaleDateString("lt-LT")}</p>
              <p><strong>Status:</strong> {b.confirmed ? "Confirmed" : "Pending confirmation"}</p>

              {editingId === b.id ? (
                <div className="mt-2">
                  <select
                    className="select"
                    onChange={(e) => setNewDateId(e.target.value)}
                    defaultValue=""
                  >
                    <option value="" disabled>Select a date</option>
                    {allDates.map((d) => (
                      <option key={d.id} value={d.id}>
                        {new Date(d.date).toLocaleDateString("lt-LT")} — {d.tour?.title}
                      </option>
                    ))}
                  </select>
                  <button
                    className="btn btn-success ml-2"
                    onClick={() => updateDate(b.id)}
                  >
                    Save
                  </button>
                  <button
                    className="btn btn-outline ml-2"
                    onClick={() => setEditingId(null)}
                  >
                    Cancel
                  </button>
                </div>
              ) : (
                <div className="mt-2 flex gap-2">
                  <button onClick={() => cancel(b.tourDate.id)} className="btn btn-error">
                    Cancel
                  </button>
                  <button onClick={() => setEditingId(b.id)} className="btn btn-secondary">
                    Change Date
                  </button>
                </div>
              )}
            </li>
          ))}
        </ul>
      )}
    </div>
  );
};
