import {configureStore} from "@reduxjs/toolkit";
import {projectApi} from '../openapi/api';
import {playerSlice} from "./playerSlice";

export const bowlingStore = configureStore({
    reducer: {
        player: playerSlice.reducer,
        [projectApi.reducerPath]: projectApi.reducer,
    },
    middleware: (getDefaultMiddleware) =>
        getDefaultMiddleware().concat(projectApi.middleware),
});

export type RootState = ReturnType<typeof bowlingStore.getState>;