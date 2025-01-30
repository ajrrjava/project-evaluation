"use server";

export async function sendProject(prevState: any, formData: FormData) {
  try {
    const formObject = Object.fromEntries(formData.entries());
    const data = {
        "projectName": formObject.projectName,
        "company": formObject.company,
        "industry" : formObject.industry,
        "type" : formObject.type,
        "amount": formObject.amount,
        "employees": formObject.employees,
        "sales": formObject.sales,
        "facts" : {
            "roi": formObject.roi,
            "npv": formObject.npv,
            "payback": formObject.payback
        }
    };

    console.log(data);

    const url = process.env.BACKEND_URL + "/evaluate";

    console.log(url);

    const response = await fetch(url, {
        method: 'POST',
        mode: 'cors',
        headers: {
          'Content-Type': 'application/json',
        //           'Access-Control-Allow-Credentials': 'true',
          'Access-Control-Allow-Origin': '*',
          'Access-Control-Allow-Methods': '*',
          "Access-Control-Allow-Headers": "X-CSRF-Token, X-Requested-With, Accept, Accept-Version, Content-Length, Content-MD5, Content-Type, Date, X-Api-Version"
        },
        body: JSON.stringify(data),
    });

   const r = await response.json();

   return JSON.stringify(r);

  } catch (err) {
      console.log(err);
    return "Error submitting the project data";
  }
}

export const getBackendURL = async () => {
  return process.env.BACKEND_URL;
};