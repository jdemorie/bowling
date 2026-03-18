import {projectApi} from "./api";

type TagTypes =
    | "GetScore";

export const enhancedApi = projectApi.enhanceEndpoints<
    TagTypes
>({
    addTagTypes: [
        "GetScore",
    ],
    endpoints: {
        getScore: {
            providesTags: (_, __, req) => [
                {
                    type: "GetScore",
                },
            ],
        },
        start: {
            invalidatesTags: (_, __, req) => [],
        },
        play: {
            invalidatesTags: (_, __, req) => [
                {
                    type: "GetScore",
                },
            ],
        },
    },
});

export const {
    useGetScoreQuery,
    useStartMutation,
    usePlayMutation
} = enhancedApi;