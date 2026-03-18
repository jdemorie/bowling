import {type FC, useMemo} from "react";
import type {FetchBaseQueryError} from "@reduxjs/toolkit/query";
import type {SerializedError} from "@reduxjs/toolkit";
import {StyledErrorMessage} from "./SharedStyles";

interface ErrorMessageProps {
    error: FetchBaseQueryError | SerializedError;
}

const ErrorMessage: FC<ErrorMessageProps> = ({error}) => {
    const msg = useMemo(() => {
        if ("data" in error) {
            return (error.data as { message?: string })?.message || "An unknown error occurred.";
        } else if ("message" in error) {
            return error.message || "An unknown error occurred.";
        }
        return "An unknown error occurred.";
    }, [error]);

    return (
        <StyledErrorMessage>
            {msg}
        </StyledErrorMessage>
    );
};

export default ErrorMessage;