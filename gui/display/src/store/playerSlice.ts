import {createSlice, PayloadAction} from "@reduxjs/toolkit";
import {useDispatch, useSelector} from "react-redux";
import {useCallback} from "react";

interface PlayerState {
    name: string;
    rookie?: number;
}

const initialState: PlayerState = {
    name: "",
};

export const playerSlice = createSlice({
    name: 'player',
    initialState,
    reducers: {
        setName: (state, {payload}: PayloadAction<string>) => {
            state.name = payload;
        },
        setRookie: (state, {payload}: PayloadAction<number>) => {
            state.rookie = payload;
        }
    },
});

export const useName = () =>
    useSelector(
        (state: { ['player']: PlayerState }) =>
            state['player'].name,
    );

export const useSetName = () => {
    const dispatch = useDispatch();
    return useCallback(
        (name: string) => {
            dispatch(setName(name));
        },
        [dispatch],
    );
};

export const useRookie = () =>
    useSelector(
        (state: { ['player']: PlayerState }) =>
            state['player'].rookie,
    );

export const useSetRookie = () => {
    const dispatch = useDispatch();
    return useCallback(
        (rookie: number) => {
            dispatch(setRookie(rookie));
        },
        [dispatch],
    );
}

export const {
    actions: {
        setName,
        setRookie,
    },
} = playerSlice;

export default playerSlice.reducer;