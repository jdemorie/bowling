import React from "react";
import {render, screen} from "@testing-library/react";
import StartPage from "../StartPage";
import {MemoryRouter} from "react-router";
import {Provider} from "react-redux";
import {bowlingStore} from "../../../store/bowlingStore";
import {useStartMutation} from "../../../openapi/enhancedApi";

// Mock du module
jest.mock("../../../openapi/enhancedApi", () => ({
    ...jest.requireActual("../../../openapi/enhancedApi"),
    useStartMutation: jest.fn(),
}));

describe("StartPage Component", () => {
    it("renders bowling start page", async () => {
        mockStart();
        render(
            <Provider store={bowlingStore}>
                <MemoryRouter>
                    <StartPage/>
                </MemoryRouter>
            </Provider>
        );
        const element = screen.getByText("Start New Game");
        expect(element).toBeInTheDocument();
    });
});

function mockStart() {
    const mockQuery = {
        data: null,
        isLoading: false,
        isSuccess: false,
        isError: false,
    };
    const mockStartMutation = jest.fn().mockImplementation(() =>
        Promise.resolve({
            data: [],
        }),
    );
    (useStartMutation as jest.Mock).mockReturnValue([
        mockStartMutation,
        mockQuery,
    ]);
}