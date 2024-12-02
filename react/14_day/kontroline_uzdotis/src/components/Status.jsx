export default function Status(){
    function alarm(){
        return alert("button dont work")
    }
    return(
        <button className="bg-danger" onClick={alarm}>Issue to reader</button>
    )
}