import { useEffect, useState } from 'react';
import { Test } from 'reactstrap';

export default function SurgeryTypeListing() {
    const [surgeryTypes, setSurgeryStypes] = useState([]);
async function fetchData() {
    const response = await fetch('api/v1/surgerytypes');
    setSurgeryStypes(await response.json());
}

useEffect(() => {
    const fetch = async() => {
        await fetchData();
    }

    fetch();
}, []);

    return (
        <>
            <div>
                <Table>
                    <thead>
                        <tr>
                            <th>Nombre</th>
                            <th>Conjunto de mascotas</th>
                        </tr>
                    </thead>
                    <tbody>
                        {surgeryTypes.map(() => {
                            
                        })}<tr>
                            <th scope="row">{}</th>
                            <td>Mark</td>
                            <td>Otto</td>
                            <td>@mdo</td>
                        </tr>
                        <tr>
                            <th scope="row">2</th>
                            <td>Jacob</td>
                            <td>Thornton</td>
                            <td>@fat</td>
                        </tr>
                        <tr>
                            <th scope="row">3</th>
                            <td>Larry</td>
                            <td>the Bird</td>
                            <td>@twitter</td>
                        </tr>
                    </tbody>
                </Table>
            </div>
        </>
    );
}
