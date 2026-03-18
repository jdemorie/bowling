import {type FC, type ReactNode} from "react";
import ErrorMessage from "./ErrorMessage";

export interface AwaitQueryProps {
    query: any;
    children: ReactNode;
}

const AwaitQuery: FC<AwaitQueryProps> = ({query, children}) => {
    const {error, isFetching} = query;
    return (
        <>
            {
                isFetching ? <><h1>waiting...</h1></> : error ? <ErrorMessage error={error}/> : <>{children}</>
            }
        </>
    )
};

export default AwaitQuery;