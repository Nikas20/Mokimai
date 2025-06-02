import { useForm } from "react-hook-form";
import {addTour} from "../../utils/helper/Tourservices"
import { useNavigate } from "react-router";
import {useState, useEffect} from "react";
import {Error} from "../../components/Error.jsx";

export const TourAdd = ({tour}) => {
    const navigate = useNavigate();
    const [error, setError] = useState()
    const {
        register,
        handleSubmit,
        reset,
        setValue,
        formState: { errors },
      } = useForm();

      const [isLoading, setIsLoading] = useState(false);
    const [submitError, setSubmitError] = useState(null);

const formSubmitHandler = async (data) => {
        setIsLoading(true);
        setSubmitError(null);

        const trimmedData = {
          ...data,
      name: data.name.trim(),
        }

        const payload = { ...trimmedData};
        try{
            let response1;
            response1 = await addTour(payload)
            console.log("Resetting form...");
            reset({
            });
            console.log("Form reset complete");
            navigate("/tour");  
        } catch (error) {
            setError(error.response?.data?.message || error.message)
          } finally {
            setIsLoading(false);
          }
}
return(
    <main className="grid place-items-center h-screen">
        <div className="flex flex-col gap-2 items-center">
            <form onSubmit={handleSubmit(formSubmitHandler)}>
            {submitError && <p className="bg-red-700">{submitError}</p>}

                <fieldset className=" bg-[#97a0f1] fieldset w-xs border border-base-300 p-4 rounded-box">
                    <legend className="fieldset-legend pt-8">ServiceAdd</legend>

                    <label className="fieldset-label"> Name </label>
                    <input {...register("name", {
                      required:"Name is required",
                      minLength:3,
                      maxLength:150,
                      pattern:"^[A-Za-z0-9\s-]+$"
                    })} 
                      type="text" 
                    className="input focus:outline-[0px] focus:border-base-300" 
                    placeholder="Enter name of service" />
                    

                    <button type="submit" className="btn bg-black border-neutral-950 text-white hover:bg-white hover:text-neutral-950 mt-4">ServiceAdd</button>

                </fieldset>
                <Error error={error} isHidden={!error} />
            </form>
        </div>
    </main>
)
}