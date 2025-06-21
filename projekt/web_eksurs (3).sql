-- phpMyAdmin SQL Dump
-- version 5.2.2
-- https://www.phpmyadmin.net/
--
-- Хост: db
-- Время создания: Июн 21 2025 г., 20:10
-- Версия сервера: 8.0.41
-- Версия PHP: 8.2.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `web_eksurs`
--

-- --------------------------------------------------------

--
-- Структура таблицы `account`
--

CREATE TABLE `account` (
  `id` bigint NOT NULL,
  `email` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Дамп данных таблицы `account`
--

INSERT INTO `account` (`id`, `email`, `password`) VALUES
(4, 'cadstcat@gmail.com', '$2a$10$TSGEQ0gX73GQPJkryzSRaeJbcOcjC41wx69gECdS0S.QrC9R0AzU2'),
(5, 'vetcat@gmail.com', '$2a$10$Jcp9tzi.Vf0yZ2aoyzqnZenothUY9xY.fh5r6yxAxG3XeKvIuQCSO'),
(6, 'Cataa@gmail.com', '$2a$10$AL9H0.Gcgd7kc81.0zya0uf6QElBvXh3SXAtwxy4uwcWkKLn7PlD.'),
(8, 'kotaewra@gmail.com', '$2a$10$YSGgqYnemGo7uL2XdzSP6umlsKXYBj8jtMUQriuQJp8Et3Sgrao2e'),
(9, 'catlord@gmail.com', '$2a$10$abMiY7rcA/WnIVI9G7lyqeaUS0e4HUp9B.HLGHWJrA4/760gb03Nm'),
(10, 'catlorde@gmail.com', '$2a$10$Y3fnmkun6qNZkQLfDYgRBe9pbtu98TNS0qXIY/aXxVJqpyF58i/wi'),
(11, 'teste@gmail.com', '$2a$10$FOXeGSv0NxITHQKuD.ke1OezD2xcgTXegx0k2FXwgPPooEEq584CS');

-- --------------------------------------------------------

--
-- Структура таблицы `account_roles`
--

CREATE TABLE `account_roles` (
  `account_id` bigint NOT NULL,
  `role_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Дамп данных таблицы `account_roles`
--

INSERT INTO `account_roles` (`account_id`, `role_id`) VALUES
(4, 1),
(5, 1),
(6, 1),
(8, 1),
(9, 1),
(11, 1),
(10, 2);

-- --------------------------------------------------------

--
-- Структура таблицы `bookings`
--

CREATE TABLE `bookings` (
  `id` bigint NOT NULL,
  `user_id` bigint NOT NULL,
  `tour_date_id` bigint NOT NULL,
  `confirmed` tinyint(1) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Структура таблицы `category`
--

CREATE TABLE `category` (
  `id` bigint NOT NULL,
  `category_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Дамп данных таблицы `category`
--

INSERT INTO `category` (`id`, `category_name`) VALUES
(1, 'CATEGORY_INDIVIDUAL'),
(2, 'CATEGORY_GROUP');

-- --------------------------------------------------------

--
-- Структура таблицы `feedback`
--

CREATE TABLE `feedback` (
  `id` bigint NOT NULL,
  `user_id` bigint NOT NULL,
  `tour_id` bigint NOT NULL,
  `rating` tinyint DEFAULT NULL,
  `comment` text,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Дамп данных таблицы `feedback`
--

INSERT INTO `feedback` (`id`, `user_id`, `tour_id`, `rating`, `comment`, `created_at`) VALUES
(1, 10, 8, 5, 'vvv', '2025-06-20 23:21:20'),
(2, 10, 8, 1, '13', '2025-06-20 23:38:42'),
(3, 10, 8, 5, '33', '2025-06-20 23:39:26'),
(4, 10, 8, 5, '2', '2025-06-20 23:41:43');

-- --------------------------------------------------------

--
-- Структура таблицы `roles`
--

CREATE TABLE `roles` (
  `id` bigint NOT NULL,
  `role_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Дамп данных таблицы `roles`
--

INSERT INTO `roles` (`id`, `role_name`) VALUES
(1, 'ROLE_USER'),
(2, 'ROLE_ADMIN');

-- --------------------------------------------------------

--
-- Структура таблицы `tours`
--

CREATE TABLE `tours` (
  `id` bigint NOT NULL,
  `title` varchar(255) NOT NULL,
  `description` text,
  `photo_url` varchar(512) DEFAULT NULL,
  `duration_minutes` int DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `max_participants` int DEFAULT NULL,
  `average_rating` decimal(3,2) DEFAULT '0.00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Дамп данных таблицы `tours`
--

INSERT INTO `tours` (`id`, `title`, `description`, `photo_url`, `duration_minutes`, `price`, `max_participants`, `average_rating`) VALUES
(8, 'afaf', 'afafa', 'https://t3.ftcdn.net/jpg/02/97/07/18/360_F_297071826_W4Jv8lgKJ338d9grf68ocN3AaNjohkZ3.jpg', 323, 12.00, 0, 4.00),
(12, 'aaaa', 'aaaaa', 'aaaa', 12, 12.00, 0, NULL);

-- --------------------------------------------------------

--
-- Структура таблицы `tours_category`
--

CREATE TABLE `tours_category` (
  `tour_id` bigint NOT NULL,
  `category_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Дамп данных таблицы `tours_category`
--

INSERT INTO `tours_category` (`tour_id`, `category_id`) VALUES
(8, 1),
(12, 1),
(8, 2),
(12, 2);

-- --------------------------------------------------------

--
-- Структура таблицы `tour_dates`
--

CREATE TABLE `tour_dates` (
  `id` bigint NOT NULL,
  `tour_id` bigint NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Дамп данных таблицы `tour_dates`
--

INSERT INTO `tour_dates` (`id`, `tour_id`, `date`) VALUES
(34, 8, '2025-06-20'),
(35, 8, '2025-06-21'),
(36, 8, '2025-06-22'),
(38, 12, '2025-06-22');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`) USING BTREE;

--
-- Индексы таблицы `account_roles`
--
ALTER TABLE `account_roles`
  ADD PRIMARY KEY (`account_id`,`role_id`),
  ADD KEY `role_id` (`role_id`);

--
-- Индексы таблицы `bookings`
--
ALTER TABLE `bookings`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `unique_booking` (`user_id`,`tour_date_id`),
  ADD KEY `tour_date_id` (`tour_date_id`);

--
-- Индексы таблицы `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `feedback`
--
ALTER TABLE `feedback`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `tour_id` (`tour_id`);

--
-- Индексы таблицы `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `tours`
--
ALTER TABLE `tours`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `tours_category`
--
ALTER TABLE `tours_category`
  ADD PRIMARY KEY (`tour_id`,`category_id`),
  ADD KEY `category_id` (`category_id`);

--
-- Индексы таблицы `tour_dates`
--
ALTER TABLE `tour_dates`
  ADD PRIMARY KEY (`id`),
  ADD KEY `tour_id` (`tour_id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `account`
--
ALTER TABLE `account`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT для таблицы `bookings`
--
ALTER TABLE `bookings`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT для таблицы `feedback`
--
ALTER TABLE `feedback`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT для таблицы `roles`
--
ALTER TABLE `roles`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT для таблицы `tours`
--
ALTER TABLE `tours`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT для таблицы `tour_dates`
--
ALTER TABLE `tour_dates`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `account_roles`
--
ALTER TABLE `account_roles`
  ADD CONSTRAINT `account_roles_ibfk_1` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`),
  ADD CONSTRAINT `account_roles_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`);

--
-- Ограничения внешнего ключа таблицы `bookings`
--
ALTER TABLE `bookings`
  ADD CONSTRAINT `bookings_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `account` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `bookings_ibfk_2` FOREIGN KEY (`tour_date_id`) REFERENCES `tour_dates` (`id`) ON DELETE CASCADE;

--
-- Ограничения внешнего ключа таблицы `feedback`
--
ALTER TABLE `feedback`
  ADD CONSTRAINT `feedback_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `account` (`id`),
  ADD CONSTRAINT `feedback_ibfk_2` FOREIGN KEY (`tour_id`) REFERENCES `tours` (`id`);

--
-- Ограничения внешнего ключа таблицы `tours_category`
--
ALTER TABLE `tours_category`
  ADD CONSTRAINT `tours_category_ibfk_1` FOREIGN KEY (`tour_id`) REFERENCES `tours` (`id`),
  ADD CONSTRAINT `tours_category_ibfk_2` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`);

--
-- Ограничения внешнего ключа таблицы `tour_dates`
--
ALTER TABLE `tour_dates`
  ADD CONSTRAINT `tour_dates_ibfk_1` FOREIGN KEY (`tour_id`) REFERENCES `tours` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
