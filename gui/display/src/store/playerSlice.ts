import {createSlice, PayloadAction} from "@reduxjs/toolkit";
import {useDispatch, useSelector} from "react-redux";
import {useCallback} from "react";

interface PlayerState {
    name: string;
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

export const {
    actions: {
        setName,
    },
} = playerSlice;

export default playerSlice.reducer;