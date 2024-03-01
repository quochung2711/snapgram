import { Button } from "@/components/ui/button";
import * as z from "zod";
import { zodResolver } from "@hookform/resolvers/zod";
import { useForm } from "react-hook-form";
import {
  Form,
  FormControl,
  FormDescription,
  FormField,
  FormItem,
  FormLabel,
  FormMessage,
} from "@/components/ui/form"
import { Input } from "@/components/ui/input"
import { SignUpValidation } from "@/lib/validation";
import Loader from "@/components/shared/loader";
import {Link} from 'react-router-dom';
import { UserRegister } from "@/apiModel/UserApiModel";
import { User } from "@/model";

const SignUpForm = () => {
 
  const isLoading = false;

  //const [userInfo, setUserInfo] = useState();

  const usersInfo: User ={
    name: "",
    username: "",
    email: "",
    password: "",
    isActive: true,
    roleId: 1
  }
  
  // 1. Define your form.
  const form = useForm<z.infer<typeof SignUpValidation>>({
    resolver: zodResolver(SignUpValidation),
    defaultValues: {
      name: '',
      username: '',
      email: '',
      password: '',
    },
  })
 

  // 2. Define a submit handler.
  async function onSubmit(values: z.infer<typeof SignUpValidation>) {
    // Do something with the form values.
    // ✅ This will be type-safe and validated.
    //const newUser = await createNewUserAccount(values);
    //registerUser();
    usersInfo.email = values.email;
    usersInfo.name = values.name;
    usersInfo.password = values.password;
    usersInfo.username = values.password;
    const userLogin = await UserRegister(usersInfo)
    console.log(userLogin);
  }


  return (
    
    <Form {...form}>
      {/* Logo this app */}
      <div className="sm:w-420 flex-center flex-col">
        <img src="\assets\images\logo.svg" alt="logo"></img>
        <h2 className="h3-bold md:h2-bold pt-5 sm:pt-12">
          Create a new account.
        </h2>
        <p className="text-light-3 small-medium md:base-regular">To use Snapgram enter yours details</p>
      </div>
      
      {/* Form login Name attributes */}
      <form onSubmit={form.handleSubmit(onSubmit)} 
        className="flex flex-col gap-1 min-w-fit max-w-fit mt-2">
        <FormField
          control={form.control}
          name="name"
          render={({ field }) => (
            <FormItem>
              <FormLabel>Name</FormLabel>
              <FormControl>
                <Input type="text" className="shad-input" {...field} />
              </FormControl>
              <FormDescription>
                
              </FormDescription>
              <FormMessage />
            </FormItem>
          )}
        />
        {/* Username attributes */}
        <FormField
          control={form.control}
          name="username"
          render={({ field }) => (
            <FormItem>
              <FormLabel>Username</FormLabel>
              <FormControl>
                <Input type="text" className="shad-input" {...field} />
              </FormControl>
              <FormDescription>
                
              </FormDescription>
              <FormMessage />
            </FormItem>
          )}
        />

        {/** Email attributes */}
        <FormField
          control={form.control}
          name="email"
          render={({ field }) => (
            <FormItem>
              <FormLabel>Email</FormLabel>
              <FormControl>
                <Input type="email" className="shad-input" {...field} />
              </FormControl>
              <FormDescription>
                
              </FormDescription>
              <FormMessage />
            </FormItem>
          )}
        />

        {/** password attributes */}
        <FormField
          control={form.control}
          name="password"
          render={({ field }) => (
            <FormItem>
              <FormLabel>Password</FormLabel>
              <FormControl>
                <Input type="password" className="shad-input" {...field} />
              </FormControl>
              <FormDescription>
                
              </FormDescription>
              <FormMessage />
            </FormItem>
          )}
        />  

        {/** Login button */}
        <Button type="submit" className="shad-button_primary">
            {isLoading ?(
              <div className="flex-center gap-2">
                  <Loader/> Loading...
              </div>
            ): 'Sign up'}
        </Button>

        {/** Register user */}
        <p className="text-small-regular text-light-2 text-center mt-2">
          Already have an account?
          <Link to="/sign-up" 
                className="text-primary-500 text-small-semibold ml-1"> Log in</Link>
        </p>

      </form>
    </Form>
  )
}

export default SignUpForm
