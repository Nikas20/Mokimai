export default function Child({text}) {

    return <ul> 
        {text.map((list, index) => <li key={index}>{list}</li>)}
    </ul>
    
    
}