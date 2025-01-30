'use client';

import { title } from "@/components/primitives";
import {Form} from '@heroui/form';
import {Button} from '@heroui/button';
import {CheckboxGroup, Checkbox} from "@heroui/checkbox";
import { Input } from "@heroui/input";
import {RadioGroup, Radio} from "@heroui/radio";
import {Alert} from "@heroui/alert";
import { FormEvent, useActionState} from "react";
import { sendProject } from '@/app/actions'

export default function EvaluationPage() {
//   const [{errors}, formAction] = useActionState(sendProject, {
  const [state, formAction] = useActionState(sendProject, "");

  return (
    <div className="">
      <h1 className={title()}>Project Sheet</h1>
        <Form
            className="grid grid-cols-2 gap-4 py-8"
            action={formAction}
//             validationErrors={errors}
        >
        <div className="col-span-2">
            {state ? (
                <Alert
                  color="danger"
                  isVisible={state?true:false}
                  title={state}
                  variant="faded"
                />
            ) : (<div></div>) }
        </div>
        <div className="col-span-1">
            <Input
                className="py-2"
                isRequired
                defaultValue=""
                name="projectName"
                label="Project"
                labelPlacement="outside"
                type="text"
                variant="underlined"
                placeholder="Enter Project Name"
            />
            <Input
                className="py-2"
                isRequired
                defaultValue=""
                name="industry"
                label="Industry"
                labelPlacement="outside"
                type="text"
                variant="underlined"
                placeholder="Enter Industry"
            />
            <Input
                className="py-2"
                isRequired
                defaultValue=""
                name="sales"
                label="Sales"
                labelPlacement="outside"
                type="text"
                variant="underlined"
                placeholder="Enter Sales"
                pattern="\d{1,9}\.\d{1,2}"
            />
        </div>
        <div className="col-span-1">
            <Input
                className="py-2"
                isRequired
                defaultValue=""
                name="company"
                label="Company"
                labelPlacement="outside"
                type="text"
                variant="underlined"
                placeholder="Enter Company name"
            />
            <Input
                className="py-2"
                isRequired
                defaultValue=""
                name="employees"
                label="Employees"
                labelPlacement="outside"
                type="text"
                variant="underlined"
                placeholder="Enter number of employees"
                pattern="\d{1,9}"
            />
        </div>
        <div className="col-span-1">
            <RadioGroup className="py-2" name="type" label="Project Type" orientation="vertical">
                <Radio value="1">Productive</Radio>
                <Radio value="2">Commercial</Radio>
                <Radio value="3">R&D</Radio>
                <Radio value="4">Other</Radio>
            </RadioGroup>
            <Input
                className="py-2"
                isRequired
                defaultValue=""
                name="amount"
                label="Requested Amount"
                labelPlacement="outside"
                type="text"
                variant="underlined"
                placeholder="Enter Requested Amount"
                pattern="\d{1,9}\.\d{1,2}"
            />
        </div>
        <div className="col-span-1">
            <fieldset>
                <legend>Facts:</legend>
                <Input
                    className="py-2"
                    isRequired
                    defaultValue=""
                    name="roi"
                    label="Return on Investment"
                    labelPlacement="outside"
                    type="text"
                    variant="underlined"
                    placeholder="Enter ROI"
                    pattern="\d{1,3}\.\d{1,2}"
                />
                <Input
                    className="py-2"
                    isRequired
                    defaultValue=""
                    name="npv"
                    label="NPV"
                    labelPlacement="outside"
                    type="text"
                    variant="underlined"
                    placeholder="Enter NPV"
                    pattern="\d{1,9}\.\d{1,2}"
                />
                <Input
                    className="py-2"
                    isRequired
                    defaultValue=""
                    name="payback"
                    label="Payback"
                    labelPlacement="outside"
                    type="text"
                    variant="underlined"
                    placeholder="Enter Payback"
                    pattern="\d{1,3}"
                />
            </fieldset>
        </div>
        <div className="col-span-1">
        </div>
        <div className="col-span-1">
            <div className="flex gap-2 py-4">
                <Button type="submit" className="w-1/2" color="primary">Submit</Button>
                <Button type="reset" className="w-1/2" variant="flat" >Reset</Button>
            </div>
        </div>
      </Form>
    </div>
  );
}
