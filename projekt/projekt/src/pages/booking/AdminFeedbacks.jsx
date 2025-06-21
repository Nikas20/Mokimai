import { useEffect, useState } from "react";
import api from "../../utils/api";
import { Error } from "../../components/Error";

export const AdminFeedbacks = () => {
  const [feedbacks, setFeedbacks] = useState([]);
  const [error, setError] = useState("");

  const fetchFeedbacks = async () => {
    try {
      const res = await api.get("/feedback");
      setFeedbacks(res.data);
    } catch (err) {
      setError("Ошибка загрузки отзывов");
    }
  };

  useEffect(() => {
    fetchFeedbacks();
  }, []);

  return (
    <div className="p-4">
      <h2 className="text-xl font-bold mb-4">Отзывы пользователей</h2>
      {error && <Error message={error} />}

      {feedbacks.length === 0 ? (
        <p>Отзывов пока нет.</p>
      ) : (
        <ul className="space-y-4">
          {feedbacks.map((f) => (
            <li key={f.id} className="border p-3 rounded bg-gray-100">
              <p><strong>Тур:</strong> {f.tourTitle}</p>
              <p><strong>Пользователь:</strong> {f.userEmail}</p>
              <p><strong>Оценка:</strong> {f.rating}/5</p>
              <p><strong>Комментарий:</strong> {f.comment}</p>
              <p className="text-sm text-gray-500">
                Дата: {new Date(f.createdAt).toLocaleDateString()}
              </p>
            </li>
          ))}
        </ul>
      )}
    </div>
  );
};
