import { title } from "@/components/primitives";

export default function AboutPage() {
  return (
    <div>
        <div className="text-center justify-center">
            <h1 className={title()}>About</h1>
        </div>
        <div className="divs">
            This is a demo that was written to demonstrate the use of the following technologies used in the front-end and back-end:
            <br/>
            <ul className="circle-bullet">
                <li>Spring Boot</li>
                <li>Drools (business rules framework)</li>
                <li>NextJS</li>
                <li>HeroUI (former NextUI)</li>
            </ul>
        </div>
    </div>
  );
}
