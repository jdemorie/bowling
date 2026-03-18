import React from "react";

interface GridProps {
    headers: string[];
    data?: Array<Record<string, string>>;
    testId?: string;
}

const Grid: React.FC<GridProps> = ({headers, data, testId}) => {
    return (
        <table style={{borderCollapse: "collapse", width: "100%"}} data-testid={testId}>
            <thead>
            <tr>
                {headers.map((header, index) => (
                    <th
                        key={index}
                        style={{
                            border: "1px solid #ddd",
                            padding: "8px",
                            textAlign: "left",
                            backgroundColor: "#f2f2f2",
                        }}
                    >
                        {header}
                    </th>
                ))}
            </tr>
            </thead>
            <tbody>
            {data?.map((row, rowIndex) => (
                <tr key={rowIndex}>
                    {headers.map((header, colIndex) => (
                        <td
                            key={colIndex}
                            style={{
                                border: "1px solid #ddd",
                                padding: "8px",
                                backgroundColor: "#f2f2f2",
                            }}
                        >
                            {row[header]}
                        </td>
                    ))}
                </tr>
            ))}
            </tbody>
        </table>
    );
}

export default Grid;
