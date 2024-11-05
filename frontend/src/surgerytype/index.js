import { useEffect, useState } from "react";
import { Table } from "reactstrap"
import tokenService from "../services/token.service";

export default function SurgeryTypeListing() {
    const [types, setTypes] = useState([])


    const getAllTypes = async () => {
        const response = await fetch('/api/v1/surgerytypes', {
            headers: {
                Authorization: `Bearer ${tokenService.getLocalAccessToken()}`
            }
        })
        if(!response.ok) {
            throw new Error('Failed to fetch types')
        }
        return await response.json()
    }

    useEffect(() => {
        const getAll = async () => {
            try {
                const data = await getAllTypes()
                console.log(data)
                setTypes(data)
            } catch (error) {
                console.error(error)
            }
        }
        getAll()
    }, [])

    return (
        <>
            <h3>List of Surgery Types</h3>
            <Table>
                    <thead>
                        <tr>
                            <th>Surgery Type</th>
                            <th>Susceptible Pet Types</th>
                        </tr>
                    </thead>
                    <tbody>
                        {types.map((type) => (
                            <tr key={type.id}>
                                <td>{type.name}</td>
                                <td>
                                    <ul>
                                        {type.susceptiblePetTypes.map((petType) => (
                                            <li key={petType.id}>{petType.name}</li>
                                        ))}
                                    </ul>
                                </td>
                            </tr>
                        ))}
                    </tbody>
                </Table>
        </>
    );
}