import React from "react";
import {render, screen, within} from "@testing-library/react";
import {MemoryRouter} from "react-router";
import {Provider} from "react-redux";
import {bowlingStore} from "../../../store/bowlingStore";
import GamePage from "../GamePage";
import {useGetScoreQuery, usePlayMutation} from "../../../openapi/enhancedApi";
import {ScoreBean} from "../../../openapi/api";

// Mock du module
jest.mock("../../../openapi/enhancedApi", () => ({
    ...jest.requireActual("../../../openapi/enhancedApi"),
    useGetScoreQuery: jest.fn(),
    usePlayMutation: jest.fn(),
}));

describe("GamePage Component", () => {
    it("renders bowling game page", async () => {
        mockGetScore([
            {name: "Player 1", turns: [{value: "00"}], score: 100},
            {name: "Player 2", turns: [{value: "00"}], score: 150},
        ]);
        mockPlay();
        render(
            <Provider store={bowlingStore}>
                <MemoryRouter>
                    <GamePage/>
                </MemoryRouter>
            </Provider>
        );
        const element = screen.getByText("Bowling score");
        expect(element).toBeInTheDocument();
        const scoreGrid = await screen.findByTestId("grid");
        expect(scoreGrid).toBeInTheDocument();
        expect(within(scoreGrid).getByText("Player 1")).toBeInTheDocument();
        expect(within(scoreGrid).getByText("Player 2")).toBeInTheDocument();
    });

    it("should be able to throw ball", async () => {
        mockGetScore([
            {name: "Player 1", score: 0},
        ]);
        mockPlay();
        render(
            <Provider store={bowlingStore}>
                <MemoryRouter>
                    <GamePage/>
                </MemoryRouter>
            </Provider>
        );
        const button = screen.getByText("Throw Ball");
        expect(button).toBeInTheDocument();
        button.click();
        const launchingElement = await screen.findByText("Launching ball...");
        expect(launchingElement).toBeInTheDocument();
    });
});

function mockGetScore(data: ScoreBean[]) {
    (useGetScoreQuery as jest.Mock).mockReturnValue({
        data: data,
        isLoading: false,
        isError: false,
    });
}

function mockPlay() {
    const promiseWithUnwrap = {
        unwrap: () => {
            return Promise.resolve({
                data: [],
            });
        },
    };
    const mockPlayMutation = jest.fn().mockImplementation(() => promiseWithUnwrap);
    (usePlayMutation as jest.Mock).mockReturnValue([mockPlayMutation]);
}

