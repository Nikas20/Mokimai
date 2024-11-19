import Header from "./components/Header";
import PostImage from "./components/PostImage";
import PostContent from "./components/PostContent";
import Box from "./components/Box";
import "./App.css";

export default function App() {
  return (
    <div className="container">
      <div className="row">
        <div className="col-12">
          <Header 
          title="Labas, as joda"
          link="src/assets/black-cat.jpg"
          />
        </div>
      </div>

      <div className="row">
        <div className="col-12 col-sm-6">
          <PostImage 
          link2="src/assets/white-cat.webp"
          />
          <PostContent
          title2="As baltiklis" 
          text2="Kodel mane taip pavadino"
          />
        </div>
        <div className="col-12 col-sm-6">
          <PostImage 
          link2="src/assets/grey-Cat.jpg"
          />
          <PostContent 
          title2="As dulke" 
          text2="eisiu megot, iki ritojaus"
          />
        </div>
      </div>

      <div className="row">
        <div className="col-6 mb-2 col-sm-3">
          <Box 
          bagraund = "bg-success"
          />
        </div>
        <div className="col-6 mb-2 col-sm-3">
          <Box 
          bagraund = "bg-primary"
          />
        </div>
        <div className="col-6 mb-2 col-sm-3">
          <Box 
          bagraund = "bg-danger"
          />
        </div>
        <div className="col-6 mb-2 col-sm-3">
          <Box 
          bagraund = "bg-warning"
          />
        </div>
      </div>
    </div>
  );
}
