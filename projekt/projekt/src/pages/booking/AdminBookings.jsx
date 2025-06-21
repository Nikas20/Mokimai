import { useEffect, useState } from "react";
import api from "../../utils/api";

export const AdminBookings = () => {
  const [bookings, setBookings] = useState([]);
  const [error, setError] = useState("");

  const fetchAllBookings = async () => {
    try {
      const res = await api.get("/bookings");
      setBookings(res.data);
    } catch (err) {
      setError("Failed to load bookings");
    }
  };

  const confirm = async (bookingId) => {
    try {
      await api.put(`/bookings/${bookingId}/confirm`);
      fetchAllBookings();
    } catch (err) {
      setError("Failed to confirm booking");
    }
  };

  useEffect(() => {
    fetchAllBookings();
  }, []);

  return (
    <div className="p-4 max-w-4xl mx-auto">
      <h2 className="text-2xl font-bold mb-4">📋 All Bookings</h2>

      {error && <p className="text-red-500">{error}</p>}

      {bookings.length === 0 ? (
        <p>No bookings found</p>
      ) : (
        <table className="table w-full table-zebra">
          <thead>
            <tr>
              <th>ID</th>
              <th>User ID</th>
              <th>Tour</th>
              <th>Date</th>
              <th>Status</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {bookings.map((b) => (
              <tr key={b.id}>
                <td>{b.id}</td>
                <td>{b.userId}</td>
                <td>{b.tourDate?.tour?.title || "—"}</td>
                <td>{new Date(b.tourDate?.date).toLocaleDateString("en-GB")}</td>
                <td>
                  {b.confirmed ? (
                    <span className="text-green-600 font-semibold">✅ Confirmed</span>
                  ) : (
                    <span className="text-yellow-600 font-semibold">⏳ Pending</span>
                  )}
                </td>
                <td>
                  {!b.confirmed && (
                    <button
                      onClick={() => confirm(b.id)}
                      className="btn btn-sm btn-primary"
                    >
                      Confirm
                    </button>
                  )}
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
};
