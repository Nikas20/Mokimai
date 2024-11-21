export default function Child({text}) {

    return <ul> 
        {text.map((list) => <li>{list}</li>)}
    </ul>
    
    
}