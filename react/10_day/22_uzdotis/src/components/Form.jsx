import {useForm} from "react-hook-form"
export default function Form() {
  const {register, handleSubmit, formState:{errors},} = useForm()
  const onSubmit = async (data) => {
    try {
      const response = await fetch("http://localhost:8080/animals", {
        method: "POST",
        body: JSON.stringify(data),
        headers: {
          "Content-Type": "application/json",
        },
      });

      if (!response.ok) {
        throw new Error(`Response status: ${response.status}`);
      }
    } catch (error) {
      console.error(error);
    }
  };
  return (
    <form onSubmit={handleSubmit(onSubmit)} className="col-4 mx-auto">
      <div className="mb-3">
        <label
          htmlFor="name"
          className="form-label"
        >
          Name
        </label>
        <input
          type="text"
          id="name"
          className="form-control"
          {...register("name",{required: true,pattern: /^[A-Z][a-z]+$/ })}
        />
        {errors.name?.type === "required" && <p>Name field cannot be empty</p>}
      </div>

      <div className="mb-3">
        <label
          htmlFor="type"
          className="form-label"
        >
          Type
        </label>
        <input
          type="text"
          id="type"
          className="form-control"
          {...register("type",{required: true, minLength: 2, maxLength: 50})}
        />
        {errors.type?.type === "required" && <p>Type field cannot be empty</p>}
      </div>

      <div className="mb-3">
        <label
          htmlFor="breed"
          className="form-label"
        >
          Breed
        </label>
        <input
          type="text"
          id="breed"
          className="form-control"
          {...register("breed", {required: true, minLength: 5, maxLength: 100, pattern: /^[A-Z][a-z]+$/ })}
        />
        {errors.breed?.type === "required" && <p>Breed field cannot be empty</p>}
      </div>

      <div className="mb-3">
        <label
          htmlFor="age"
          className="form-label"
        >
          Age
        </label>
        <input
          type="number"
          id="age"
          className="form-control"
          {...register("age", {required: true, min: 1, max: 100})}
        />
        {errors.age?.type === "required" && <p>Age field cannot be empty</p>}
      </div>

      <div className="mb-3">
        <label
          htmlFor="weight"
          className="form-label"
        >
          Weight
        </label>
        <input
          type="number"
          id="weight"
          step="0.01"
          className="form-control"
          {...register("weight",{min:0.05})}
        />
      </div>

      <div className="mb-3">
        <label
          htmlFor="gender"
          className="form-label"
        >
          Gender
        </label>
        <input
          type="text"
          id="gender"
          className="form-control"
          {...register("gender",{required: true})}
        />
        {errors.gender?.type === "required" && <p>Gender field cannot be empty</p>}
      </div>

      <button
        type="submit"
        className="btn btn-primary"
      >
        Submit
      </button>
    </form>
  );
}