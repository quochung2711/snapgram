import * as z from "zod";

export const SignUpValidation = z.object({
    name: z.string().min(5, {message: 'Name must contains a minimum of 5 characters.'}).max(20, {message: 'Name must contains a maximum of 20 characters'}),
    username: z.string().min(10, {message: 'UserName must contains a minimum of 10 characters '}).max(50, {message: 'UserName must contains a maximum of 50 characters'}),
    email: z.string().email({message:'Email is invalid.'}),
    password: z.string().min(6, {message:' Password must contains a minimum of 6 characters. '})
  })