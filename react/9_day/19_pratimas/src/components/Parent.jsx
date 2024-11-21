import DisplayCounter from "./DisplayCounter";
import IncrementButton from "./IncrementButton";
import { useState } from "react";

export default function Parent(){
    const [count, setCount] = useState(0);
    
    return (
        <div>
            <h1>Counter App</h1>
             <DisplayCounter count = {count}/> 
            <IncrementButton increment = {() => setCount(count + 1)}/> 
        </div>
    );
}