import {FC} from "react";
import {CenterContainer} from "./SharedStyles";

const ErrorElement: FC = () => {
    return (
        <CenterContainer>
            <h1>Something went wrong</h1>
        </CenterContainer>
    )
}

export default ErrorElement;